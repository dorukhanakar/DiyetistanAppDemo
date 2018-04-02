package com.diyetistan.diyetistanapp.dto


class BlogDTO() {

    var url: String = ""
    var summary: String = ""
    var content: String = ""

    constructor(imageURL: String, summary: String, content: String) : this() {

        this.url = imageURL
        this.summary = summary
        this.content = content
    }
}