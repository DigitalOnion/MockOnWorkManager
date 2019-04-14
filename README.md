# MockOnWorkManager
Sample app to do Test Cases by injecting a fake (or a mock) dependency on an Android Worker  

## Description
MockOnWorkManager is a sample app with a technique I put together when I needed to develop an app which uses WorkManager. 

The way WorkManager works is by defining a Worker class and instructing WorkManager to create objects of that class based on certain conditions. WorkManager creates the objects and initialize them with parameters that we pass.

That is very good, but if our worker has dependencies, we need to inject either, Mock or Fake dependencies to do the testing. This is very important in TDD and complex projects.

The App is quite simple. You type on a box and the app reverses the string and presents it underneath. Simple, right, but to make it a valuable sample app, I built it like this:

* There is a TextChangedListener
* every time we type something we enqueue a WorkRequest
* WorkManager runs a Worker which has a TextReverser
* The TextReverser is treated similar to a backend call and is a dependency of the Worker
* We inject the TextReverser with Dagger
* Gradle builds everything, but when we run a testcase, it compiles different Component
* The testcase then injects a different dependency to the Worker allowing us to isolate the Worker from the dependency.

I used this principle on our app and I could develop the Workers to schedule Upload and Download remote operations with a Fake Http Client. The development was faster and the result robust.

## Check it out.
Any questions? Ask Luis Virueña.
