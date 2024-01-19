import SwiftUI

@main
struct StarProfileApp: App {
    
    init(){
           KoinApplication.start()
       }
       
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
