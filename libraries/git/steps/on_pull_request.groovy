package library.git.steps

void call(Map args = [:], body) {
  if (!env.CHANGE_TARGET) {
    return
  }

  if (args.from && env.CHANGE_BRANCH != args.from) {
    return
  }

  if (args.to && env.CHANGE_TARGET != args.to) {
    return
  }

  body()
}
