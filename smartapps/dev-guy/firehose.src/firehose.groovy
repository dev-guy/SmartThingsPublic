/**
 *  Firehose
 *
 *  Copyright 2016 Terris Linenbach
 *
 */
definition(
    name: "Firehose",
    namespace: "dev-guy",
    author: "Terris Linenbach",
    description: "Firehose",
    category: "",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    oauth: true) {
    appSetting "partnerId"
    appSetting "apiKey"
    appSetting "url"
    appSetting "contactSensors"
}

preferences {
	section("Web service") {
		input "url", "text", title: "URL of web service"
	}
    section("Who are you?") {
        input "partnerId", "text", title: "ID"
        input "apiKey", "text", title: "Password"
    }
    section("Devices") {
        input "contactSensors", "capability.contactSensor", required: true, multiple:true
    }
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	contactSensors.each { contact -> 
    	subscribe contact, "contact.open", openHandler
    	subscribe contact, "contact.closed", closedHandler
    }
}

def openHandler(evt) {
    log.debug "$evt.name: $evt.value"
}

def closedHandler(evt) {
    log.debug "$evt.name: $evt.value"
}
