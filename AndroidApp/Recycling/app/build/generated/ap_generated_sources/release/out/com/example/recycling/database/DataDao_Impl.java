package com.example.recycling.database;

import android.database.Cursor;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataDao_Impl implements DataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Data> __insertionAdapterOfData;

  private final EntityDeletionOrUpdateAdapter<Data> __updateAdapterOfData;

  public DataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfData = new EntityInsertionAdapter<Data>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Data` (`id`,`area`,`jan`,`feb`,`mar`,`apr`,`may`,`jun`,`jul`,`aug`,`sep`,`oct`,`nov`,`dec`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Data value) {
        stmt.bindLong(1, value.id);
        if (value.area == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.area);
        }
        stmt.bindLong(3, value.jan);
        stmt.bindLong(4, value.feb);
        stmt.bindLong(5, value.mar);
        stmt.bindLong(6, value.apr);
        stmt.bindLong(7, value.may);
        stmt.bindLong(8, value.jun);
        stmt.bindLong(9, value.jul);
        stmt.bindLong(10, value.aug);
        stmt.bindLong(11, value.sep);
        stmt.bindLong(12, value.oct);
        stmt.bindLong(13, value.nov);
        stmt.bindLong(14, value.dec);
      }
    };
    this.__updateAdapterOfData = new EntityDeletionOrUpdateAdapter<Data>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Data` SET `id` = ?,`area` = ?,`jan` = ?,`feb` = ?,`mar` = ?,`apr` = ?,`may` = ?,`jun` = ?,`jul` = ?,`aug` = ?,`sep` = ?,`oct` = ?,`nov` = ?,`dec` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Data value) {
        stmt.bindLong(1, value.id);
        if (value.area == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.area);
        }
        stmt.bindLong(3, value.jan);
        stmt.bindLong(4, value.feb);
        stmt.bindLong(5, value.mar);
        stmt.bindLong(6, value.apr);
        stmt.bindLong(7, value.may);
        stmt.bindLong(8, value.jun);
        stmt.bindLong(9, value.jul);
        stmt.bindLong(10, value.aug);
        stmt.bindLong(11, value.sep);
        stmt.bindLong(12, value.oct);
        stmt.bindLong(13, value.nov);
        stmt.bindLong(14, value.dec);
        stmt.bindLong(15, value.id);
      }
    };
  }

  @Override
  public void insertData(final Data... data) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfData.insert(data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateData(final Data... data) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfData.handleMultiple(data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Data> findByMonthAndArea(final String area) {
    final String _sql = "SELECT * FROM data where area LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (area == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, area);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfArea = CursorUtil.getColumnIndexOrThrow(_cursor, "area");
      final int _cursorIndexOfJan = CursorUtil.getColumnIndexOrThrow(_cursor, "jan");
      final int _cursorIndexOfFeb = CursorUtil.getColumnIndexOrThrow(_cursor, "feb");
      final int _cursorIndexOfMar = CursorUtil.getColumnIndexOrThrow(_cursor, "mar");
      final int _cursorIndexOfApr = CursorUtil.getColumnIndexOrThrow(_cursor, "apr");
      final int _cursorIndexOfMay = CursorUtil.getColumnIndexOrThrow(_cursor, "may");
      final int _cursorIndexOfJun = CursorUtil.getColumnIndexOrThrow(_cursor, "jun");
      final int _cursorIndexOfJul = CursorUtil.getColumnIndexOrThrow(_cursor, "jul");
      final int _cursorIndexOfAug = CursorUtil.getColumnIndexOrThrow(_cursor, "aug");
      final int _cursorIndexOfSep = CursorUtil.getColumnIndexOrThrow(_cursor, "sep");
      final int _cursorIndexOfOct = CursorUtil.getColumnIndexOrThrow(_cursor, "oct");
      final int _cursorIndexOfNov = CursorUtil.getColumnIndexOrThrow(_cursor, "nov");
      final int _cursorIndexOfDec = CursorUtil.getColumnIndexOrThrow(_cursor, "dec");
      final List<Data> _result = new ArrayList<Data>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Data _item;
        _item = new Data();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.area = _cursor.getString(_cursorIndexOfArea);
        _item.jan = _cursor.getLong(_cursorIndexOfJan);
        _item.feb = _cursor.getLong(_cursorIndexOfFeb);
        _item.mar = _cursor.getLong(_cursorIndexOfMar);
        _item.apr = _cursor.getLong(_cursorIndexOfApr);
        _item.may = _cursor.getLong(_cursorIndexOfMay);
        _item.jun = _cursor.getLong(_cursorIndexOfJun);
        _item.jul = _cursor.getLong(_cursorIndexOfJul);
        _item.aug = _cursor.getLong(_cursorIndexOfAug);
        _item.sep = _cursor.getLong(_cursorIndexOfSep);
        _item.oct = _cursor.getLong(_cursorIndexOfOct);
        _item.nov = _cursor.getLong(_cursorIndexOfNov);
        _item.dec = _cursor.getLong(_cursorIndexOfDec);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
