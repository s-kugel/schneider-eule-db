INSERT INTO StaffStatus (code, label) VALUES
    ('ENABLED', '有効'),
    ('DISABLED', '無効') AS newRows
ON DUPLICATE KEY UPDATE
    label = newRows.label
