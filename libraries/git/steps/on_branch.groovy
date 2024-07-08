package library.git.steps

void call(Map args = [:], body) {
  if (env.CHANGE_TARGET || env.TAG_NAME) {
    return
  }

  if (args.name && env.BRANCH_NAME != args.name) {
    return
  }

  if (args.match && env.BRANCH_NAME !=~ args.match) {
    return
  }

  if (args.primary && env.BRANCH_IS_PRIMARY != "true") {
    return
  }

  body()
}
