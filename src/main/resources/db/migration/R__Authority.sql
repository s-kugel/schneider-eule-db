INSERT INTO Authority (code, label) VALUES
    ('VIEW_STAFF', '社内ユーザー閲覧'),
    ('EDIT_STAFF', '社内ユーザー編集'),
    ('VIEW_ROLE', 'ロール閲覧'),
    ('EDIT_ROLE', 'ロール編集') AS newRows
ON DUPLICATE KEY UPDATE
    label = newRows.label
