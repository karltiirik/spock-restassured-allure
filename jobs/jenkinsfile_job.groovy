pipelineJob('job-dsl-plugin') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/karltiirik/spock-restassured-allure.git')
                    }
                    branch('*/jenkins')
                }
            }
        }
    }
}