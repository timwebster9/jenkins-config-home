pipelineJob("gradle-gatling") {

    triggers {
       githubPush()
    }

    wrappers {
        buildName('#${BUILD_NUMBER}: ${ENV, var="GIT_LOCAL_BRANCH"}')
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