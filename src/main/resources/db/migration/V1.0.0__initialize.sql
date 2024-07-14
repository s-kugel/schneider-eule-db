CREATE TABLE IF NOT EXISTS StaffStatus (
    code VARCHAR(20) NOT NULL,
    label VARCHAR(20) NOT NULL,
    PRIMARY KEY (code)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = '社内ユーザーステータス';

CREATE TABLE IF NOT EXISTS Staff (
    id VARCHAR(26) NOT NULL COMMENT '社内ユーザーID',
    staffStatus VARCHAR(20) COMMENT '社内ユーザーステータス',
    email VARCHAR(256) COMMENT 'メールアドレス',
    staffName VARCHAR(50) COMMENT '社内ユーザー名',
    password VARCHAR(126) COMMENT 'パスワード',
    oldPassword VARCHAR(126) COMMENT '前回パスワード',
    passwordLastUpdatedAt DATETIME COMMENT 'パスワード最終更新日時',
    loginFailureCount INT COMMENT 'ログイン失敗回数',
    createdAt DATETIME COMMENT '作成日時',
    createdBy VARCHAR(26) COMMENT '作成者',
    updatedAt DATETIME COMMENT '更新日時',
    updatedBy VARCHAR(26) COMMENT '更新者',
    version INT NOT NULL DEFAULT 0 COMMENT 'バージョン',
    PRIMARY KEY (id),
    CONSTRAINT fk_Staff_StaffStatus FOREIGN KEY (staffStatus) REFERENCES StaffStatus (code) ON DELETE NO ACTION ON UPDATE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = '社内ユーザー';

CREATE INDEX idx_Staff_staffStatus ON Staff (staffStatus);
CREATE INDEX idx_Staff_email ON Staff (email);
CREATE INDEX idx_Staff_staffName ON Staff (staffName);

CREATE TABLE IF NOT EXISTS Role (
    id VARCHAR(26) NOT NULL COMMENT 'ロールID',
    roleName VARCHAR(50) COMMENT 'ロール名',
    createdAt DATETIME COMMENT '作成日時',
    createdBy VARCHAR(26) COMMENT '作成者',
    updatedAt DATETIME COMMENT '更新日時',
    updatedBy VARCHAR(26) COMMENT '更新者',
    version INT NOT NULL DEFAULT 0 COMMENT 'バージョン',
    PRIMARY KEY (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'ロール';

CREATE INDEX idx_Role_roleName ON Role (roleName);

CREATE TABLE IF NOT EXISTS ApplicationClock (
    timeZone VARCHAR(20) NOT NULL COMMENT 'タイムゾーン',
    baseTime DATETIME NOT NULL COMMENT 'アプリケーション時刻',
    createdAt DATETIME COMMENT '作成日時',
    updatedAt DATETIME COMMENT '更新日時',
    PRIMARY KEY (timeZone, baseTime)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'アプリケーション時刻設定';

CREATE TABLE IF NOT EXISTS Authority (
    code VARCHAR(30) NOT NULL,
    label VARCHAR(30) NOT NULL,
    PRIMARY KEY (code)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = '権限';

CREATE TABLE IF NOT EXISTS RoleAuthority (
    roleId VARCHAR(26) NOT NULL COMMENT 'ロールID',
    authority VARCHAR(30) NOT NULL COMMENT '権限',
    createdAt DATETIME COMMENT '作成日時',
    createdBy VARCHAR(26) COMMENT '作成者',
    updatedAt DATETIME COMMENT '更新日時',
    updatedBy VARCHAR(26) COMMENT '更新者',
    version INT NOT NULL DEFAULT 0 COMMENT 'バージョン',
    PRIMARY KEY (roleId, authority),
    CONSTRAINT fk_RoleAuthority_Authority FOREIGN KEY (authority) REFERENCES Authority (code) ON DELETE NO ACTION ON UPDATE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'ロール・権限';

CREATE INDEX idx_RoleAuthority_roleId ON RoleAuthority (roleId);
CREATE INDEX idx_RoleAuthority_authority ON RoleAuthority (authority);

CREATE TABLE IF NOT EXISTS StaffRole (
    staffId VARCHAR(26) NOT NULL COMMENT '社内ユーザーID',
    roleId VARCHAR(26) NOT NULL COMMENT 'ロールID',
    createdAt DATETIME COMMENT '作成日時',
    createdBy VARCHAR(26) COMMENT '作成者',
    updatedAt DATETIME COMMENT '更新日時',
    updatedBy VARCHAR(26) COMMENT '更新者',
    version INT NOT NULL DEFAULT 0 COMMENT 'バージョン',
    PRIMARY KEY (staffId, roleId)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'ロール・権限';

CREATE TABLE IF NOT EXISTS BackofficeProperties (
    propertyName VARCHAR(50) NOT NULL COMMENT 'キー',
    propertyValue VARCHAR(50) COMMENT 'プロパティ値',
    createdAt DATETIME COMMENT '作成日時',
    createdBy VARCHAR(26) COMMENT '作成者',
    updatedAt DATETIME COMMENT '更新日時',
    updatedBy VARCHAR(26) COMMENT '更新者',
    version INT NOT NULL DEFAULT 0 COMMENT 'バージョン',
    PRIMARY KEY (propertyName)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'バックオフィスプロパティ';
