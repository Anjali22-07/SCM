package com.scm.smartcontactmanager.Helper;

public class ResourceNotFoundException extends RuntimeException {

      public ResourceNotFoundException(String message){
        super(message);  //passing the message up the inheritance chain so Java can store it.
      }

      public ResourceNotFoundException(){
        super();
      }
}
