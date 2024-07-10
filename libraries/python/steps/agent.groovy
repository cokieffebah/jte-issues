package library.python.steps

void call(Map args = [:], body) {
  def version = config.version ?: '3'

  podTemplate(
    containers: [name: 'python', image: "python:${version}", command: 'sleep', args: '1d']
  ) {
    node(POD_LABEL) {
      container('python') {
        body()
      }
    }
  }
}
