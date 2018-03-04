package com.anothercompany.Lock;

public final class Lock {
    private String currentLockStatus = "unlocked";

    public boolean acquireLock(){
        currentLockStatus = "Locked";
        return true;
    }

    public boolean releaseLock(){
        currentLockStatus = "Unlocked";
        return true;
    }

    public String getLockStatus(){
        return currentLockStatus;
    }
}
