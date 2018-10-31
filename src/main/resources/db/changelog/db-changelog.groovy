package db.changelog

databaseChangeLog() {
    include(file: 'version/change-sets.groovy', relativeToChangelogFile: true)
    include(file: 'provision/data-provision.groovy', relativeToChangelogFile: true)
}