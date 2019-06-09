package com.muaaz.joosuf.encrypted.redditclient.RSSHandler.XMLTags;
/**
 * final child of entry within RSS document.
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "author", strict = false)
public class Author implements Serializable{

    @Element(name = "name")
    private String name;

    @Element(name = "uri")
    private String uri;

    public Author(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }
    public Author(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                '}' ;
    }
}
