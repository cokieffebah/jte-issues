package library.git.steps

@Init
void call() {
  node {
    checkout scm

    env.GIT_SHA = sh(script: "git rev-parse HEAD", returnStdout: true).trim()
    env.GIT_STATUS_PREFIX = config.status_prefix ?: 'ci/jenkins: '

    stash(name: 'sourcecode', useDefaultExcludes: false)
  }
}
