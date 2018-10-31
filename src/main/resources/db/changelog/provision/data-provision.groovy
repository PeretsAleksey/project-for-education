package db.changelog.provision

databaseChangeLog() {

    changeSet(id: '0001_load_users_data', author: 'Oleksii_Perets@epam.com', runOnChange: true) {
        preConditions(onFail: 'MARK_RAN') {
            and() {
                dbms(type: 'mysql')
            }
        }
        loadUpdateData(schemaName: 'library', tableName: 'users', file: 'db/changelog/data/users.csv', primaryKey: 'pk_id') {

        }
    }
}