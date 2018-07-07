pipelineJob("jenkins-pen-test") {

    triggers {
       githubPush()
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/timwebster9/jenkins-pen-test.git')
                    }
                    branch('master')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}