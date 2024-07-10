package library.python.steps

void call(Map args = [:], body) {
  def version = config.version ?: '3'

  
    node(POD_LABEL) {
      container('python') {
        body()
      }
    }

}
