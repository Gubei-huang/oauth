package com.hwj.dao;

import com.hwj.pojo.Storage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageDao {
    List<Storage> selectStorage();
    Storage selectStorageById(long id);
    void insertStorage(Storage storage);
    List<Storage> findStorage(Storage storage);
}
