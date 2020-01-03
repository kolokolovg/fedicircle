package org.guyvernk.fedicircle.core.activitystream.types;


import lombok.Data;
import org.guyvernk.fedicircle.core.jsonld.Context;

@Data
@Context("https://www.w3.org/ns/activitystreams")
public class Object {

    private final String type = "Object";

}