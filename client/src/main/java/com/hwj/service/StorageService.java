package com.hwj.service;

import com.hwj.pojo.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> selectStorage();
    Storage selectStorageById(long id);
    boolean insertStorage(Storage storage);
    List<Storage> findStorage(Storage storage);
}
