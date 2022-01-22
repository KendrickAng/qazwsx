package simpledb.query;

import simpledb.record.RID;

/**
 * The interface implemented by all updateable scans.
 *
 * @author Edward Sciore
 */
public interface UpdateScan extends Scan {
    /**
     * Modify the field value of the current record.
     *
     * @param fldname the name of the field
     * @param val     the new value, expressed as a Constant
     */
    void setVal(String fldname, Constant val);

    /**
     * Modify the field value of the current record.
     *
     * @param fldname the name of the field
     * @param val     the new integer value
     */
    void setInt(String fldname, int val);

    /**
     * Modify the field value of the current record.
     *
     * @param fldname the name of the field
     * @param val     the new string value
     */
    void setString(String fldname, String val);

    /**
     * Insert a new record somewhere in the scan.
     */
    void insert();

    /**
     * Delete the current record from the scan.
     */
    void delete();

    /**
     * Return the id of the current record.
     *
     * @return the id of the current record
     */
    RID getRid();

    /**
     * Position the scan so that the current record has
     * the specified id.
     *
     * @param rid the id of the desired record
     */
    void moveToRid(RID rid);
}
