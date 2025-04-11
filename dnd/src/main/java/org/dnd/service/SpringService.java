package org.dnd.service;

import org.dnd.enums.Operations;
import org.dnd.exceptions.IllegalStringException;
import org.dnd.exceptions.NullPointerException;
import org.dnd.service.impl.SSI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

import static org.dnd.enums.Operations.SUBTRACT;
import static org.dnd.enums.Operations.SUM;

@Service
public class SpringService implements SSI {

    public HttpEntity<String> rollDiceBodyBuilder(Integer result) {
        String json = String.format("%d", result);
        return new HttpEntity<>(json);
    }

    public Integer getResult(String body) {
        String half = body.split("\"")[3];
        return Integer.valueOf(half);
    }

    @Override
    public ResponseEntity<HttpEntity<String>> rollDice(Integer times, Integer face, Operations op, Integer val) {
        if (times == null || face == null || val == null || op == null ||
                times < 1 || face < 2 || val < 0) {
            throw new NullPointerException("Wrong Argument");
        }

        ResponseEntity<HttpEntity<String>> rd = rollDice(times, face);
        String body = rd.getBody().getBody(); 
        Integer n = getResult(body); 

        if (op == SUBTRACT) {
            n -= val;
        } else if (op == SUM) {
            n += val;
        }

        HttpEntity<String> entity = rollDiceBodyBuilder(n);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpEntity<String>> rollDice(Integer times, Integer face) {
        if (times == null || face == null || times < 1 || face < 2) {
            throw new NullPointerException("Wrong Argument");
        }

        Random random = new Random();
        Integer sum = 0;
        for (int i = 0; i < times; i++) {
            sum += random.nextInt(face) + 1; 
        }

        HttpEntity<String> entity = rollDiceBodyBuilder(sum);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpEntity<String>> rollDice() {
        Random random = new Random();
        Operations op = random.nextBoolean() ? SUM : SUBTRACT;
        Integer times = random.nextInt(1, 11);
        Integer face = random.nextInt(2, 101);
        Integer n = random.nextInt(0, 11);
        if ((times * face) < n || op.equals(SUBTRACT)) {
            times += random.nextInt(1,11);
            face += random.nextInt(1, 51);
        }
        return rollDice(times, face, op, n);
    }
}
