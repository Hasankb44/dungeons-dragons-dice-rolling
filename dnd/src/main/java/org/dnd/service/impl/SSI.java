package org.dnd.service.impl;

import org.dnd.enums.Operations;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface SSI {

    public ResponseEntity<HttpEntity<String>> rollDice(Integer times, Integer many, Operations op, Integer val);

    public ResponseEntity<HttpEntity<String>> rollDice();// Random property

    public ResponseEntity<HttpEntity<String>> rollDice(Integer times, Integer many);

}
