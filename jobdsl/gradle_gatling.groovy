pipelineJob("gradle-gatling") {

    configure { project ->
       project / 'buildwrappers' {
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

        wrappers {
        //buildName('#${BUILD_NUMBER}: ${ENV, var="GIT_LOCAL_BRANCH"}')
        buildName('test-name')
    }
}