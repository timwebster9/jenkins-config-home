pipelineJob("gradle-gatling") {

    configure { project ->
       flow-definition / 'buildwrappers' {
           'buildName'('test-name')
       }

    }

    triggers {
       githubPush()
    }

    definition {
        cpsScm {
            scm {
                git {
                    extensions {
                        wipeOutWorkspace()
                        localBranch()
                    }
                    remote {
                        url('https://github.com/timwebster9/gradle-gatling.git')
                    }
                    //branch('master')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}