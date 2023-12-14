package com.example.betterto_do.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.betterto_do.models.Task;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TasksDAO_Impl implements TasksDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final TasksTypeConverters __tasksTypeConverters = new TasksTypeConverters();

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __updateAdapterOfTask;

  public TasksDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Task` (`id`,`title`,`description`,`dueDate`,`priorty`,`notification`,`notificationID`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        final String _tmp = __tasksTypeConverters.fromUUID(entity.getId());
        if (_tmp == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, _tmp);
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        final Long _tmp_1 = __tasksTypeConverters.fromDate(entity.getDueDate());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, _tmp_1);
        }
        statement.bindLong(5, entity.getPriorty());
        final int _tmp_2 = entity.getNotification() ? 1 : 0;
        statement.bindLong(6, _tmp_2);
        if (entity.getNotificationID() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getNotificationID());
        }
      }
    };
    this.__deletionAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Task` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        final String _tmp = __tasksTypeConverters.fromUUID(entity.getId());
        if (_tmp == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, _tmp);
        }
      }
    };
    this.__updateAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Task` SET `id` = ?,`title` = ?,`description` = ?,`dueDate` = ?,`priorty` = ?,`notification` = ?,`notificationID` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        final String _tmp = __tasksTypeConverters.fromUUID(entity.getId());
        if (_tmp == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, _tmp);
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        final Long _tmp_1 = __tasksTypeConverters.fromDate(entity.getDueDate());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, _tmp_1);
        }
        statement.bindLong(5, entity.getPriorty());
        final int _tmp_2 = entity.getNotification() ? 1 : 0;
        statement.bindLong(6, _tmp_2);
        if (entity.getNotificationID() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getNotificationID());
        }
        final String _tmp_3 = __tasksTypeConverters.fromUUID(entity.getId());
        if (_tmp_3 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_3);
        }
      }
    };
  }

  @Override
  public void addTask(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTask.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Task>> getAllTasks() {
    final String _sql = "SELECT * FROM task";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"task"}, false, new Callable<List<Task>>() {
      @Override
      @Nullable
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPriorty = CursorUtil.getColumnIndexOrThrow(_cursor, "priorty");
          final int _cursorIndexOfNotification = CursorUtil.getColumnIndexOrThrow(_cursor, "notification");
          final int _cursorIndexOfNotificationID = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationID");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Task _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __tasksTypeConverters.toUUID(_tmp);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Date _tmpDueDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDueDate);
            }
            _tmpDueDate = __tasksTypeConverters.toDate(_tmp_1);
            final int _tmpPriorty;
            _tmpPriorty = _cursor.getInt(_cursorIndexOfPriorty);
            final boolean _tmpNotification;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfNotification);
            _tmpNotification = _tmp_2 != 0;
            final String _tmpNotificationID;
            if (_cursor.isNull(_cursorIndexOfNotificationID)) {
              _tmpNotificationID = null;
            } else {
              _tmpNotificationID = _cursor.getString(_cursorIndexOfNotificationID);
            }
            _item = new Task(_tmpId,_tmpTitle,_tmpDescription,_tmpDueDate,_tmpPriorty,_tmpNotification,_tmpNotificationID);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Task> getTaskFromId(final UUID id) {
    final String _sql = "SELECT * FROM task WHERE id=(?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __tasksTypeConverters.fromUUID(id);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"task"}, false, new Callable<Task>() {
      @Override
      @Nullable
      public Task call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPriorty = CursorUtil.getColumnIndexOrThrow(_cursor, "priorty");
          final int _cursorIndexOfNotification = CursorUtil.getColumnIndexOrThrow(_cursor, "notification");
          final int _cursorIndexOfNotificationID = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationID");
          final Task _result;
          if (_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __tasksTypeConverters.toUUID(_tmp_1);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Date _tmpDueDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDueDate);
            }
            _tmpDueDate = __tasksTypeConverters.toDate(_tmp_2);
            final int _tmpPriorty;
            _tmpPriorty = _cursor.getInt(_cursorIndexOfPriorty);
            final boolean _tmpNotification;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfNotification);
            _tmpNotification = _tmp_3 != 0;
            final String _tmpNotificationID;
            if (_cursor.isNull(_cursorIndexOfNotificationID)) {
              _tmpNotificationID = null;
            } else {
              _tmpNotificationID = _cursor.getString(_cursorIndexOfNotificationID);
            }
            _result = new Task(_tmpId,_tmpTitle,_tmpDescription,_tmpDueDate,_tmpPriorty,_tmpNotification,_tmpNotificationID);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getTaskCount() {
    final String _sql = "SELECT COUNT(*) FROM task";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"task"}, false, new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
