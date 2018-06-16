pipelineJob("gradle-gatling") {

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