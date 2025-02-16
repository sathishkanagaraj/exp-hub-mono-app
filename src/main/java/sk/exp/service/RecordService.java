package sk.exp.service;

import sk.exp.model.Record;
import sk.exp.repository.RecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecordService {
    private final RecordRepository repository;

    public RecordService(RecordRepository repository) {
        this.repository = repository;
    }

    public List<Record> getAllRecords() {
        return repository.findAll();
    }

    public Record createRecord(Record record) {
        return repository.save(record);
    }

    public Record updateRecord(Long id, Record newRecord) {
        return repository.findById(id).map(record -> {
            record.setName(newRecord.getName());
            record.setScore(newRecord.getScore());
            return repository.save(record);
        }).orElse(null);
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}
