package tech.buildrun.Api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
    @RestController
    @RequestMapping(path = "/tasks")
    public class ApiController {

        private List<String> tasks = new ArrayList<>();

        private ObjectMapper objectMapper;

        public ApiController(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        // GET → listar tarefas
        @GetMapping
        public ResponseEntity<String> getTasks() throws Exception {
            return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
        }

        // POST → criar tarefa
        @PostMapping
        public ResponseEntity<String> createTask(@RequestBody String tarefa) {
            tasks.add(tarefa);
            return ResponseEntity.ok("tarefa criada");
        }
        //Delete deletar tarefas
        @DeleteMapping
        public ResponseEntity <Void> cleartasks (){
            tasks = new ArrayList<>();
            return ResponseEntity.ok().build();
        }
    }
