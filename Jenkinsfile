
stage("checkout") {
  node {
    checkout scm
  }
}

stage("build") {
  node {
    sh "oc start-build workshop-app --from-dir=. -F"
  }
}
