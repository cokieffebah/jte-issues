package library.python.steps

void call() {
  String buildTool = config.build_tool ?: 'tox'

  stage("${env.GIT_STATUS_PREFIX}static code analysis") {
    env.VIRTUAL_ENV = "/tmp/venv"
    sh "python -m venv ${env.VIRTUAL_ENV}"
    env.PATH        = "${env.VIRTUAL_ENV}/bin:${env.PATH}"

    sh 'mkdir -p reports'

    switch(buildTool) {
      case 'tox':
        sh 'pip install tox'
        sh 'tox -e flake8'

        break;
      default:
        error "unsupported build tool: ${config.build_tool}"
    }
  }
}
