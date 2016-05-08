/**
 *  Firehose
 *
 *  Copyright 2016 Terris Linenbach
 *
 */
definition(
    name: "Firehose",
    namespace: "dev-guy",
    author: "T Linenbach",
    description: "Sends data to a web server",
    category: "",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    oauth: [displayName: "Firehose", displayLink: ""]) {
    appSetting "partnerId"
    appSetting "partnerKey"
    appSetting "contactSensors"
}

preferences {
    section("Who are you?") {
        input "partnerId", "text", title: "Partner ID"
        input "partnerKey", "text", title: "Partner Key"
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
	// TODO: subscribe to attributes, devices, locations, etc.
}

def unsubscribe() {
}

// TODO: implement event handlers