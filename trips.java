// ORM class for table 'trips'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sat Apr 12 20:21:41 MSK 2025
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class trips extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("trip_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.trip_id = (Integer)value;
      }
    });
    setters.put("vendor_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.vendor_id = (Integer)value;
      }
    });
    setters.put("pickup_datetime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.pickup_datetime = (java.sql.Timestamp)value;
      }
    });
    setters.put("dropoff_datetime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.dropoff_datetime = (java.sql.Timestamp)value;
      }
    });
    setters.put("passenger_count", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.passenger_count = (Integer)value;
      }
    });
    setters.put("trip_distance", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.trip_distance = (java.math.BigDecimal)value;
      }
    });
    setters.put("rate_code", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.rate_code = (Integer)value;
      }
    });
    setters.put("store_and_fwd_flag", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.store_and_fwd_flag = (String)value;
      }
    });
    setters.put("payment_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.payment_type = (Integer)value;
      }
    });
    setters.put("fare_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.fare_amount = (java.math.BigDecimal)value;
      }
    });
    setters.put("extra", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.extra = (java.math.BigDecimal)value;
      }
    });
    setters.put("mta_tax", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.mta_tax = (java.math.BigDecimal)value;
      }
    });
    setters.put("tip_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.tip_amount = (java.math.BigDecimal)value;
      }
    });
    setters.put("tolls_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.tolls_amount = (java.math.BigDecimal)value;
      }
    });
    setters.put("imp_surcharge", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.imp_surcharge = (java.math.BigDecimal)value;
      }
    });
    setters.put("total_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.total_amount = (java.math.BigDecimal)value;
      }
    });
    setters.put("pickup_location_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.pickup_location_id = (Integer)value;
      }
    });
    setters.put("dropoff_location_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        trips.this.dropoff_location_id = (Integer)value;
      }
    });
  }
  public trips() {
    init0();
  }
  private Integer trip_id;
  public Integer get_trip_id() {
    return trip_id;
  }
  public void set_trip_id(Integer trip_id) {
    this.trip_id = trip_id;
  }
  public trips with_trip_id(Integer trip_id) {
    this.trip_id = trip_id;
    return this;
  }
  private Integer vendor_id;
  public Integer get_vendor_id() {
    return vendor_id;
  }
  public void set_vendor_id(Integer vendor_id) {
    this.vendor_id = vendor_id;
  }
  public trips with_vendor_id(Integer vendor_id) {
    this.vendor_id = vendor_id;
    return this;
  }
  private java.sql.Timestamp pickup_datetime;
  public java.sql.Timestamp get_pickup_datetime() {
    return pickup_datetime;
  }
  public void set_pickup_datetime(java.sql.Timestamp pickup_datetime) {
    this.pickup_datetime = pickup_datetime;
  }
  public trips with_pickup_datetime(java.sql.Timestamp pickup_datetime) {
    this.pickup_datetime = pickup_datetime;
    return this;
  }
  private java.sql.Timestamp dropoff_datetime;
  public java.sql.Timestamp get_dropoff_datetime() {
    return dropoff_datetime;
  }
  public void set_dropoff_datetime(java.sql.Timestamp dropoff_datetime) {
    this.dropoff_datetime = dropoff_datetime;
  }
  public trips with_dropoff_datetime(java.sql.Timestamp dropoff_datetime) {
    this.dropoff_datetime = dropoff_datetime;
    return this;
  }
  private Integer passenger_count;
  public Integer get_passenger_count() {
    return passenger_count;
  }
  public void set_passenger_count(Integer passenger_count) {
    this.passenger_count = passenger_count;
  }
  public trips with_passenger_count(Integer passenger_count) {
    this.passenger_count = passenger_count;
    return this;
  }
  private java.math.BigDecimal trip_distance;
  public java.math.BigDecimal get_trip_distance() {
    return trip_distance;
  }
  public void set_trip_distance(java.math.BigDecimal trip_distance) {
    this.trip_distance = trip_distance;
  }
  public trips with_trip_distance(java.math.BigDecimal trip_distance) {
    this.trip_distance = trip_distance;
    return this;
  }
  private Integer rate_code;
  public Integer get_rate_code() {
    return rate_code;
  }
  public void set_rate_code(Integer rate_code) {
    this.rate_code = rate_code;
  }
  public trips with_rate_code(Integer rate_code) {
    this.rate_code = rate_code;
    return this;
  }
  private String store_and_fwd_flag;
  public String get_store_and_fwd_flag() {
    return store_and_fwd_flag;
  }
  public void set_store_and_fwd_flag(String store_and_fwd_flag) {
    this.store_and_fwd_flag = store_and_fwd_flag;
  }
  public trips with_store_and_fwd_flag(String store_and_fwd_flag) {
    this.store_and_fwd_flag = store_and_fwd_flag;
    return this;
  }
  private Integer payment_type;
  public Integer get_payment_type() {
    return payment_type;
  }
  public void set_payment_type(Integer payment_type) {
    this.payment_type = payment_type;
  }
  public trips with_payment_type(Integer payment_type) {
    this.payment_type = payment_type;
    return this;
  }
  private java.math.BigDecimal fare_amount;
  public java.math.BigDecimal get_fare_amount() {
    return fare_amount;
  }
  public void set_fare_amount(java.math.BigDecimal fare_amount) {
    this.fare_amount = fare_amount;
  }
  public trips with_fare_amount(java.math.BigDecimal fare_amount) {
    this.fare_amount = fare_amount;
    return this;
  }
  private java.math.BigDecimal extra;
  public java.math.BigDecimal get_extra() {
    return extra;
  }
  public void set_extra(java.math.BigDecimal extra) {
    this.extra = extra;
  }
  public trips with_extra(java.math.BigDecimal extra) {
    this.extra = extra;
    return this;
  }
  private java.math.BigDecimal mta_tax;
  public java.math.BigDecimal get_mta_tax() {
    return mta_tax;
  }
  public void set_mta_tax(java.math.BigDecimal mta_tax) {
    this.mta_tax = mta_tax;
  }
  public trips with_mta_tax(java.math.BigDecimal mta_tax) {
    this.mta_tax = mta_tax;
    return this;
  }
  private java.math.BigDecimal tip_amount;
  public java.math.BigDecimal get_tip_amount() {
    return tip_amount;
  }
  public void set_tip_amount(java.math.BigDecimal tip_amount) {
    this.tip_amount = tip_amount;
  }
  public trips with_tip_amount(java.math.BigDecimal tip_amount) {
    this.tip_amount = tip_amount;
    return this;
  }
  private java.math.BigDecimal tolls_amount;
  public java.math.BigDecimal get_tolls_amount() {
    return tolls_amount;
  }
  public void set_tolls_amount(java.math.BigDecimal tolls_amount) {
    this.tolls_amount = tolls_amount;
  }
  public trips with_tolls_amount(java.math.BigDecimal tolls_amount) {
    this.tolls_amount = tolls_amount;
    return this;
  }
  private java.math.BigDecimal imp_surcharge;
  public java.math.BigDecimal get_imp_surcharge() {
    return imp_surcharge;
  }
  public void set_imp_surcharge(java.math.BigDecimal imp_surcharge) {
    this.imp_surcharge = imp_surcharge;
  }
  public trips with_imp_surcharge(java.math.BigDecimal imp_surcharge) {
    this.imp_surcharge = imp_surcharge;
    return this;
  }
  private java.math.BigDecimal total_amount;
  public java.math.BigDecimal get_total_amount() {
    return total_amount;
  }
  public void set_total_amount(java.math.BigDecimal total_amount) {
    this.total_amount = total_amount;
  }
  public trips with_total_amount(java.math.BigDecimal total_amount) {
    this.total_amount = total_amount;
    return this;
  }
  private Integer pickup_location_id;
  public Integer get_pickup_location_id() {
    return pickup_location_id;
  }
  public void set_pickup_location_id(Integer pickup_location_id) {
    this.pickup_location_id = pickup_location_id;
  }
  public trips with_pickup_location_id(Integer pickup_location_id) {
    this.pickup_location_id = pickup_location_id;
    return this;
  }
  private Integer dropoff_location_id;
  public Integer get_dropoff_location_id() {
    return dropoff_location_id;
  }
  public void set_dropoff_location_id(Integer dropoff_location_id) {
    this.dropoff_location_id = dropoff_location_id;
  }
  public trips with_dropoff_location_id(Integer dropoff_location_id) {
    this.dropoff_location_id = dropoff_location_id;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof trips)) {
      return false;
    }
    trips that = (trips) o;
    boolean equal = true;
    equal = equal && (this.trip_id == null ? that.trip_id == null : this.trip_id.equals(that.trip_id));
    equal = equal && (this.vendor_id == null ? that.vendor_id == null : this.vendor_id.equals(that.vendor_id));
    equal = equal && (this.pickup_datetime == null ? that.pickup_datetime == null : this.pickup_datetime.equals(that.pickup_datetime));
    equal = equal && (this.dropoff_datetime == null ? that.dropoff_datetime == null : this.dropoff_datetime.equals(that.dropoff_datetime));
    equal = equal && (this.passenger_count == null ? that.passenger_count == null : this.passenger_count.equals(that.passenger_count));
    equal = equal && (this.trip_distance == null ? that.trip_distance == null : this.trip_distance.equals(that.trip_distance));
    equal = equal && (this.rate_code == null ? that.rate_code == null : this.rate_code.equals(that.rate_code));
    equal = equal && (this.store_and_fwd_flag == null ? that.store_and_fwd_flag == null : this.store_and_fwd_flag.equals(that.store_and_fwd_flag));
    equal = equal && (this.payment_type == null ? that.payment_type == null : this.payment_type.equals(that.payment_type));
    equal = equal && (this.fare_amount == null ? that.fare_amount == null : this.fare_amount.equals(that.fare_amount));
    equal = equal && (this.extra == null ? that.extra == null : this.extra.equals(that.extra));
    equal = equal && (this.mta_tax == null ? that.mta_tax == null : this.mta_tax.equals(that.mta_tax));
    equal = equal && (this.tip_amount == null ? that.tip_amount == null : this.tip_amount.equals(that.tip_amount));
    equal = equal && (this.tolls_amount == null ? that.tolls_amount == null : this.tolls_amount.equals(that.tolls_amount));
    equal = equal && (this.imp_surcharge == null ? that.imp_surcharge == null : this.imp_surcharge.equals(that.imp_surcharge));
    equal = equal && (this.total_amount == null ? that.total_amount == null : this.total_amount.equals(that.total_amount));
    equal = equal && (this.pickup_location_id == null ? that.pickup_location_id == null : this.pickup_location_id.equals(that.pickup_location_id));
    equal = equal && (this.dropoff_location_id == null ? that.dropoff_location_id == null : this.dropoff_location_id.equals(that.dropoff_location_id));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof trips)) {
      return false;
    }
    trips that = (trips) o;
    boolean equal = true;
    equal = equal && (this.trip_id == null ? that.trip_id == null : this.trip_id.equals(that.trip_id));
    equal = equal && (this.vendor_id == null ? that.vendor_id == null : this.vendor_id.equals(that.vendor_id));
    equal = equal && (this.pickup_datetime == null ? that.pickup_datetime == null : this.pickup_datetime.equals(that.pickup_datetime));
    equal = equal && (this.dropoff_datetime == null ? that.dropoff_datetime == null : this.dropoff_datetime.equals(that.dropoff_datetime));
    equal = equal && (this.passenger_count == null ? that.passenger_count == null : this.passenger_count.equals(that.passenger_count));
    equal = equal && (this.trip_distance == null ? that.trip_distance == null : this.trip_distance.equals(that.trip_distance));
    equal = equal && (this.rate_code == null ? that.rate_code == null : this.rate_code.equals(that.rate_code));
    equal = equal && (this.store_and_fwd_flag == null ? that.store_and_fwd_flag == null : this.store_and_fwd_flag.equals(that.store_and_fwd_flag));
    equal = equal && (this.payment_type == null ? that.payment_type == null : this.payment_type.equals(that.payment_type));
    equal = equal && (this.fare_amount == null ? that.fare_amount == null : this.fare_amount.equals(that.fare_amount));
    equal = equal && (this.extra == null ? that.extra == null : this.extra.equals(that.extra));
    equal = equal && (this.mta_tax == null ? that.mta_tax == null : this.mta_tax.equals(that.mta_tax));
    equal = equal && (this.tip_amount == null ? that.tip_amount == null : this.tip_amount.equals(that.tip_amount));
    equal = equal && (this.tolls_amount == null ? that.tolls_amount == null : this.tolls_amount.equals(that.tolls_amount));
    equal = equal && (this.imp_surcharge == null ? that.imp_surcharge == null : this.imp_surcharge.equals(that.imp_surcharge));
    equal = equal && (this.total_amount == null ? that.total_amount == null : this.total_amount.equals(that.total_amount));
    equal = equal && (this.pickup_location_id == null ? that.pickup_location_id == null : this.pickup_location_id.equals(that.pickup_location_id));
    equal = equal && (this.dropoff_location_id == null ? that.dropoff_location_id == null : this.dropoff_location_id.equals(that.dropoff_location_id));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.trip_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.vendor_id = JdbcWritableBridge.readInteger(2, __dbResults);
    this.pickup_datetime = JdbcWritableBridge.readTimestamp(3, __dbResults);
    this.dropoff_datetime = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.passenger_count = JdbcWritableBridge.readInteger(5, __dbResults);
    this.trip_distance = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.rate_code = JdbcWritableBridge.readInteger(7, __dbResults);
    this.store_and_fwd_flag = JdbcWritableBridge.readString(8, __dbResults);
    this.payment_type = JdbcWritableBridge.readInteger(9, __dbResults);
    this.fare_amount = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.extra = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.mta_tax = JdbcWritableBridge.readBigDecimal(12, __dbResults);
    this.tip_amount = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.tolls_amount = JdbcWritableBridge.readBigDecimal(14, __dbResults);
    this.imp_surcharge = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.total_amount = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.pickup_location_id = JdbcWritableBridge.readInteger(17, __dbResults);
    this.dropoff_location_id = JdbcWritableBridge.readInteger(18, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.trip_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.vendor_id = JdbcWritableBridge.readInteger(2, __dbResults);
    this.pickup_datetime = JdbcWritableBridge.readTimestamp(3, __dbResults);
    this.dropoff_datetime = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.passenger_count = JdbcWritableBridge.readInteger(5, __dbResults);
    this.trip_distance = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.rate_code = JdbcWritableBridge.readInteger(7, __dbResults);
    this.store_and_fwd_flag = JdbcWritableBridge.readString(8, __dbResults);
    this.payment_type = JdbcWritableBridge.readInteger(9, __dbResults);
    this.fare_amount = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.extra = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.mta_tax = JdbcWritableBridge.readBigDecimal(12, __dbResults);
    this.tip_amount = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.tolls_amount = JdbcWritableBridge.readBigDecimal(14, __dbResults);
    this.imp_surcharge = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.total_amount = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.pickup_location_id = JdbcWritableBridge.readInteger(17, __dbResults);
    this.dropoff_location_id = JdbcWritableBridge.readInteger(18, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(trip_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(vendor_id, 2 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeTimestamp(pickup_datetime, 3 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(dropoff_datetime, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(passenger_count, 5 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(trip_distance, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(rate_code, 7 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeString(store_and_fwd_flag, 8 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeInteger(payment_type, 9 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(fare_amount, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(extra, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(mta_tax, 12 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tip_amount, 13 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tolls_amount, 14 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(imp_surcharge, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_amount, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(pickup_location_id, 17 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(dropoff_location_id, 18 + __off, 5, __dbStmt);
    return 18;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(trip_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(vendor_id, 2 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeTimestamp(pickup_datetime, 3 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(dropoff_datetime, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(passenger_count, 5 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(trip_distance, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(rate_code, 7 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeString(store_and_fwd_flag, 8 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeInteger(payment_type, 9 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(fare_amount, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(extra, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(mta_tax, 12 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tip_amount, 13 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tolls_amount, 14 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(imp_surcharge, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_amount, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(pickup_location_id, 17 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(dropoff_location_id, 18 + __off, 5, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.trip_id = null;
    } else {
    this.trip_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.vendor_id = null;
    } else {
    this.vendor_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.pickup_datetime = null;
    } else {
    this.pickup_datetime = new Timestamp(__dataIn.readLong());
    this.pickup_datetime.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.dropoff_datetime = null;
    } else {
    this.dropoff_datetime = new Timestamp(__dataIn.readLong());
    this.dropoff_datetime.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.passenger_count = null;
    } else {
    this.passenger_count = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.trip_distance = null;
    } else {
    this.trip_distance = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.rate_code = null;
    } else {
    this.rate_code = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.store_and_fwd_flag = null;
    } else {
    this.store_and_fwd_flag = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.payment_type = null;
    } else {
    this.payment_type = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.fare_amount = null;
    } else {
    this.fare_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.extra = null;
    } else {
    this.extra = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.mta_tax = null;
    } else {
    this.mta_tax = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.tip_amount = null;
    } else {
    this.tip_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.tolls_amount = null;
    } else {
    this.tolls_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.imp_surcharge = null;
    } else {
    this.imp_surcharge = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.total_amount = null;
    } else {
    this.total_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pickup_location_id = null;
    } else {
    this.pickup_location_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.dropoff_location_id = null;
    } else {
    this.dropoff_location_id = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.trip_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.trip_id);
    }
    if (null == this.vendor_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.vendor_id);
    }
    if (null == this.pickup_datetime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.pickup_datetime.getTime());
    __dataOut.writeInt(this.pickup_datetime.getNanos());
    }
    if (null == this.dropoff_datetime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.dropoff_datetime.getTime());
    __dataOut.writeInt(this.dropoff_datetime.getNanos());
    }
    if (null == this.passenger_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.passenger_count);
    }
    if (null == this.trip_distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.trip_distance, __dataOut);
    }
    if (null == this.rate_code) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.rate_code);
    }
    if (null == this.store_and_fwd_flag) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, store_and_fwd_flag);
    }
    if (null == this.payment_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.payment_type);
    }
    if (null == this.fare_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.fare_amount, __dataOut);
    }
    if (null == this.extra) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.extra, __dataOut);
    }
    if (null == this.mta_tax) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.mta_tax, __dataOut);
    }
    if (null == this.tip_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tip_amount, __dataOut);
    }
    if (null == this.tolls_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tolls_amount, __dataOut);
    }
    if (null == this.imp_surcharge) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.imp_surcharge, __dataOut);
    }
    if (null == this.total_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_amount, __dataOut);
    }
    if (null == this.pickup_location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.pickup_location_id);
    }
    if (null == this.dropoff_location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dropoff_location_id);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.trip_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.trip_id);
    }
    if (null == this.vendor_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.vendor_id);
    }
    if (null == this.pickup_datetime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.pickup_datetime.getTime());
    __dataOut.writeInt(this.pickup_datetime.getNanos());
    }
    if (null == this.dropoff_datetime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.dropoff_datetime.getTime());
    __dataOut.writeInt(this.dropoff_datetime.getNanos());
    }
    if (null == this.passenger_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.passenger_count);
    }
    if (null == this.trip_distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.trip_distance, __dataOut);
    }
    if (null == this.rate_code) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.rate_code);
    }
    if (null == this.store_and_fwd_flag) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, store_and_fwd_flag);
    }
    if (null == this.payment_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.payment_type);
    }
    if (null == this.fare_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.fare_amount, __dataOut);
    }
    if (null == this.extra) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.extra, __dataOut);
    }
    if (null == this.mta_tax) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.mta_tax, __dataOut);
    }
    if (null == this.tip_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tip_amount, __dataOut);
    }
    if (null == this.tolls_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tolls_amount, __dataOut);
    }
    if (null == this.imp_surcharge) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.imp_surcharge, __dataOut);
    }
    if (null == this.total_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_amount, __dataOut);
    }
    if (null == this.pickup_location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.pickup_location_id);
    }
    if (null == this.dropoff_location_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dropoff_location_id);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(trip_id==null?"null":"" + trip_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(vendor_id==null?"null":"" + vendor_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_datetime==null?"null":"" + pickup_datetime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_datetime==null?"null":"" + dropoff_datetime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(passenger_count==null?"null":"" + passenger_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(trip_distance==null?"null":trip_distance.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rate_code==null?"null":"" + rate_code, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(store_and_fwd_flag==null?"null":store_and_fwd_flag, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(payment_type==null?"null":"" + payment_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fare_amount==null?"null":fare_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(extra==null?"null":extra.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mta_tax==null?"null":mta_tax.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tip_amount==null?"null":tip_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tolls_amount==null?"null":tolls_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(imp_surcharge==null?"null":imp_surcharge.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_amount==null?"null":total_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_location_id==null?"null":"" + pickup_location_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_location_id==null?"null":"" + dropoff_location_id, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(trip_id==null?"null":"" + trip_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(vendor_id==null?"null":"" + vendor_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_datetime==null?"null":"" + pickup_datetime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_datetime==null?"null":"" + dropoff_datetime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(passenger_count==null?"null":"" + passenger_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(trip_distance==null?"null":trip_distance.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rate_code==null?"null":"" + rate_code, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(store_and_fwd_flag==null?"null":store_and_fwd_flag, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(payment_type==null?"null":"" + payment_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fare_amount==null?"null":fare_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(extra==null?"null":extra.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mta_tax==null?"null":mta_tax.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tip_amount==null?"null":tip_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tolls_amount==null?"null":tolls_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(imp_surcharge==null?"null":imp_surcharge.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_amount==null?"null":total_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_location_id==null?"null":"" + pickup_location_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_location_id==null?"null":"" + dropoff_location_id, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.trip_id = null; } else {
      this.trip_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.vendor_id = null; } else {
      this.vendor_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_datetime = null; } else {
      this.pickup_datetime = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_datetime = null; } else {
      this.dropoff_datetime = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.passenger_count = null; } else {
      this.passenger_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.trip_distance = null; } else {
      this.trip_distance = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rate_code = null; } else {
      this.rate_code = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.store_and_fwd_flag = null; } else {
      this.store_and_fwd_flag = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.payment_type = null; } else {
      this.payment_type = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fare_amount = null; } else {
      this.fare_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.extra = null; } else {
      this.extra = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.mta_tax = null; } else {
      this.mta_tax = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tip_amount = null; } else {
      this.tip_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tolls_amount = null; } else {
      this.tolls_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.imp_surcharge = null; } else {
      this.imp_surcharge = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_amount = null; } else {
      this.total_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_location_id = null; } else {
      this.pickup_location_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_location_id = null; } else {
      this.dropoff_location_id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.trip_id = null; } else {
      this.trip_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.vendor_id = null; } else {
      this.vendor_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_datetime = null; } else {
      this.pickup_datetime = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_datetime = null; } else {
      this.dropoff_datetime = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.passenger_count = null; } else {
      this.passenger_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.trip_distance = null; } else {
      this.trip_distance = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rate_code = null; } else {
      this.rate_code = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.store_and_fwd_flag = null; } else {
      this.store_and_fwd_flag = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.payment_type = null; } else {
      this.payment_type = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fare_amount = null; } else {
      this.fare_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.extra = null; } else {
      this.extra = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.mta_tax = null; } else {
      this.mta_tax = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tip_amount = null; } else {
      this.tip_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tolls_amount = null; } else {
      this.tolls_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.imp_surcharge = null; } else {
      this.imp_surcharge = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_amount = null; } else {
      this.total_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_location_id = null; } else {
      this.pickup_location_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_location_id = null; } else {
      this.dropoff_location_id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    trips o = (trips) super.clone();
    o.pickup_datetime = (o.pickup_datetime != null) ? (java.sql.Timestamp) o.pickup_datetime.clone() : null;
    o.dropoff_datetime = (o.dropoff_datetime != null) ? (java.sql.Timestamp) o.dropoff_datetime.clone() : null;
    return o;
  }

  public void clone0(trips o) throws CloneNotSupportedException {
    o.pickup_datetime = (o.pickup_datetime != null) ? (java.sql.Timestamp) o.pickup_datetime.clone() : null;
    o.dropoff_datetime = (o.dropoff_datetime != null) ? (java.sql.Timestamp) o.dropoff_datetime.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("trip_id", this.trip_id);
    __sqoop$field_map.put("vendor_id", this.vendor_id);
    __sqoop$field_map.put("pickup_datetime", this.pickup_datetime);
    __sqoop$field_map.put("dropoff_datetime", this.dropoff_datetime);
    __sqoop$field_map.put("passenger_count", this.passenger_count);
    __sqoop$field_map.put("trip_distance", this.trip_distance);
    __sqoop$field_map.put("rate_code", this.rate_code);
    __sqoop$field_map.put("store_and_fwd_flag", this.store_and_fwd_flag);
    __sqoop$field_map.put("payment_type", this.payment_type);
    __sqoop$field_map.put("fare_amount", this.fare_amount);
    __sqoop$field_map.put("extra", this.extra);
    __sqoop$field_map.put("mta_tax", this.mta_tax);
    __sqoop$field_map.put("tip_amount", this.tip_amount);
    __sqoop$field_map.put("tolls_amount", this.tolls_amount);
    __sqoop$field_map.put("imp_surcharge", this.imp_surcharge);
    __sqoop$field_map.put("total_amount", this.total_amount);
    __sqoop$field_map.put("pickup_location_id", this.pickup_location_id);
    __sqoop$field_map.put("dropoff_location_id", this.dropoff_location_id);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("trip_id", this.trip_id);
    __sqoop$field_map.put("vendor_id", this.vendor_id);
    __sqoop$field_map.put("pickup_datetime", this.pickup_datetime);
    __sqoop$field_map.put("dropoff_datetime", this.dropoff_datetime);
    __sqoop$field_map.put("passenger_count", this.passenger_count);
    __sqoop$field_map.put("trip_distance", this.trip_distance);
    __sqoop$field_map.put("rate_code", this.rate_code);
    __sqoop$field_map.put("store_and_fwd_flag", this.store_and_fwd_flag);
    __sqoop$field_map.put("payment_type", this.payment_type);
    __sqoop$field_map.put("fare_amount", this.fare_amount);
    __sqoop$field_map.put("extra", this.extra);
    __sqoop$field_map.put("mta_tax", this.mta_tax);
    __sqoop$field_map.put("tip_amount", this.tip_amount);
    __sqoop$field_map.put("tolls_amount", this.tolls_amount);
    __sqoop$field_map.put("imp_surcharge", this.imp_surcharge);
    __sqoop$field_map.put("total_amount", this.total_amount);
    __sqoop$field_map.put("pickup_location_id", this.pickup_location_id);
    __sqoop$field_map.put("dropoff_location_id", this.dropoff_location_id);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
