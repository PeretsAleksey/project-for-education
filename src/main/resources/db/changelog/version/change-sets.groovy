package db.changelog.version

databaseChangeLog() {
    changeSet(id: '0001_create_users_table', author: 'Oleksii_Perets@epam.com') {
        preConditions(onFail: 'MARK_RAN') {
            not() {
                tableExists(tableName: 'users')
            }
        }
        createTable(tableName: 'users', schemaName: 'library', remarks: '') {
            column(name: 'id', type: 'varchar (36)',) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'first_name', type: 'varchar(50)') {
                constraints(nullable: false)
            }
            column(name: 'last_name', type: 'varchar(50)') {
                constraints(nullable: false)
            }
            column(name: 'email', type: 'varchar(50)') {
                constraints(nullable: false)
            }
            column(name: 'status', type: 'ENUM("ACTIVE", "INACTIVE")', defaultValue: 'ACTIVE') {
                constraints(nullable: false)
            }
            column(name: 'date_added', type: 'TIMESTAMP', defaultValueComputed: 'CURRENT_TIMESTAMP') {
                constraints(nullable: false)
            }
        }
        rollback() {
            dropTable(tableName: 'users')
        }
    }

    changeSet(id: '0002_add_role_column_in_table_users', author: 'Oleksii_Perets@epam.com') {
        preConditions(onFail: 'MARK_RAN') {
            tableExists(tableName: "users")
        }
        addColumn(tableName: 'users', schemaName: 'library') {
            column(name: 'role', type: 'ENUM("ADMIN", "MANAGER", "USER")', defaultValue: 'USER') {
                constraints(nullable: false/*, referencedTableName: 'roles', referencedColumnNames: 'id', foreignKeyName: 'FK_users_roles_id'*/)
            }
        }
        rollback() {
            dropColumn(tableName: 'users', columnName: 'role')
        }
    }
}