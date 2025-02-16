package sk.exp.controller;

import sk.exp.model.Record;
import sk.exp.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@CrossOrigin("*")  // Allow frontend to access backend
public class RecordController {
    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<Record> getAllRecords() {
        return service.getAllRecords();
    }

    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        return service.createRecord(record);
    }

    @PutMapping("/{id}")
    public Record updateRecord(@PathVariable Long id, @RequestBody Record record) {
        return service.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}