package org.dnd.controller;

import org.dnd.enums.Operations;
import org.dnd.service.impl.SSI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dnd/api")
public class SpringController {

    @Autowired
    private SSI ssi;

    @PostMapping("/roll")
    public ResponseEntity<HttpEntity<String>> rollDice(
            @RequestHeader(name = "times") Integer times,
            @RequestHeader(name = "face") Integer face,
            @RequestHeader(name = "op") Operations op,
            @RequestHeader(name = "val") Integer val
    ) {
        return ssi.rollDice(times, face, op, val);
    }

    @PostMapping("/roll/random")
    public ResponseEntity<HttpEntity<String>> rollDice() {
        return ssi.rollDice();
    }

    @PostMapping("/roll/{times}/{face}")
    public ResponseEntity<HttpEntity<String>> rollDice(
            @PathVariable("times") Integer times,
            @PathVariable("face") Integer face
    ) {
        return ssi.rollDice(times, face);
    }
}
