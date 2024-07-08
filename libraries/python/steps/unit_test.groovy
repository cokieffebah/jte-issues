package library.python.steps

void call() {
  String buildTool = config.build_tool ?: 'tox'

  stage("${env.GIT_STATUS_PREFIX}unit tests") {
    env.VIRTUAL_ENV = "/tmp/venv"
    sh "python -m venv ${env.VIRTUAL_ENV}"
    env.PATH        = "${env.VIRTUAL_ENV}/bin:${env.PATH}"

    switch(buildTool) {
      case 'tox':
        sh 'pip install tox'
        sh 'tox'

        break;
      default:
        error "unsupported build tool: ${config.build_tool}"
    }
  }
}
