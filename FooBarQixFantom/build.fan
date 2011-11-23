using build
class Build : build::BuildPod
{
  new make()
  {
    podName = "FooBarQix"
    summary = ""
    srcDirs = [`fan/`]
    depends = ["sys 1.0"]
  }
}
