package com.example.recycling.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DataDao _dataDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `area` TEXT, `jan` INTEGER NOT NULL, `feb` INTEGER NOT NULL, `mar` INTEGER NOT NULL, `apr` INTEGER NOT NULL, `may` INTEGER NOT NULL, `jun` INTEGER NOT NULL, `jul` INTEGER NOT NULL, `aug` INTEGER NOT NULL, `sep` INTEGER NOT NULL, `oct` INTEGER NOT NULL, `nov` INTEGER NOT NULL, `dec` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '99fb0f84f05990f74db83e810b5c4d0a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Data`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsData = new HashMap<String, TableInfo.Column>(14);
        _columnsData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("area", new TableInfo.Column("area", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("jan", new TableInfo.Column("jan", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("feb", new TableInfo.Column("feb", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("mar", new TableInfo.Column("mar", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("apr", new TableInfo.Column("apr", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("may", new TableInfo.Column("may", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("jun", new TableInfo.Column("jun", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("jul", new TableInfo.Column("jul", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("aug", new TableInfo.Column("aug", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("sep", new TableInfo.Column("sep", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("oct", new TableInfo.Column("oct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("nov", new TableInfo.Column("nov", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsData.put("dec", new TableInfo.Column("dec", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoData = new TableInfo("Data", _columnsData, _foreignKeysData, _indicesData);
        final TableInfo _existingData = TableInfo.read(_db, "Data");
        if (! _infoData.equals(_existingData)) {
          return new RoomOpenHelper.ValidationResult(false, "Data(com.example.recycling.database.Data).\n"
                  + " Expected:\n" + _infoData + "\n"
                  + " Found:\n" + _existingData);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "99fb0f84f05990f74db83e810b5c4d0a", "539b9844077530c44980fb944d31ac36");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Data");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Data`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DataDao dataDao() {
    if (_dataDao != null) {
      return _dataDao;
    } else {
      synchronized(this) {
        if(_dataDao == null) {
          _dataDao = new DataDao_Impl(this);
        }
        return _dataDao;
      }
    }
  }
}
