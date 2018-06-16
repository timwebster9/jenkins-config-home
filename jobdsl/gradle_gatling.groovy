pipelineJob("gradle-gatling") {

    triggers {
       githubPush()
    }

    environmentVariables {
        env('BUILD_DISPLAY_NAME', '$BUILD_NUMBER: $GIT_LOCAL_BRANCH')
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