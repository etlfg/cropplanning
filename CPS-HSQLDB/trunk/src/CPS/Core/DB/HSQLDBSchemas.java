/*
 * HQSLDBSchemas.java
 *
 * Created on March 13, 2007, 11:15 AM
 *
 *
 */

package CPS.Core.DB;

/**
 *
 * @author Clayton
 */
public class HSQLDBSchemas {
   
   private HSQLDBSchemas() {}
   
   static String cropPlansListSchema() {
      
      String s;
      
      s  = " id        INTEGER IDENTITY, ";
      s += " plan_name VARCHAR(256) ";
      
      return s;
      
   }
   
   static String cropPlanSchema() {
      
      String s;
      
      /* this schema, by itself, could be considered a "planting" */
      s  = "id            INTEGER IDENTITY PRIMARY KEY, ";
      s += "crop_id       INTEGER, "; // References CROPS_VARIETIES.id
      s += "plant_mtd_id  INTEGER, "; // References PLANTING_METHODS.id
      
      s += "crop_name   VARCHAR, ";
      s += "var_name    VARCHAR, ";
      s += "groups      VARCHAR, ";
      s += "successions BOOLEAN, "; // TODO remove
      s += "location    VARCHAR, ";
      
      s += "keywords  VARCHAR, ";
      s += "status    VARCHAR, ";
      s += "completed BOOLEAN, ";
      s += "fudge     FLOAT, "; // TODO remove
      s += "other_req VARCHAR, ";
      s += "notes     VARCHAR, ";
      
      s += "maturity        INTEGER, ";
      s += "mat_adjust      INTEGER, ";
      s += "planting_adjust INTEGER, ";
      s += "ds_adjust       INTEGER, ";
      s += "season_adjust   INTEGER, ";
      s += "time_to_tp      INTEGER, ";
      s += "misc_adjust     INTEGER, ";
      
      s += "date_plant      DATE, ";
      s += "date_tp         DATE, ";
      s += "date_harvest    DATE, ";
      
      s += "beds_to_plant   FLOAT, ";
      s += "rows_p_bed      INTEGER, ";
      s += "plants_needed   INTEGER, ";
      s += "rowft_to_plant  INTEGER, ";
      s += "inrow_space     FLOAT, ";
      s += "row_space       FLOAT, ";
      s += "plants_to_start INTEGER, ";
      s += "flat_size       VARCHAR, ";
      s += "flats_needed    FLOAT, ";
      s += "planter         VARCHAR, ";
      s += "planter_setting VARCHAR, ";
      
      s += "yield_p_foot    FLOAT, ";
      s += "total_yield     FLOAT, ";
      s += "yield_num_weeks INTEGER, ";
      s += "yield_p_week    FLOAT, ";
      
      s += "crop_unit       VARCHAR, ";
      s += "crop_unit_value FLOAT, ";
      
      s += "FOREIGN KEY ( crop_id ) REFERENCES crops_varieties ( id ), ";
      
      return s;
   }
   
   static String cropAndVarietySchema() {
      
      String s;
      
      s   = "id                 INTEGER IDENTITY PRIMARY KEY, ";
      s  += "crop_name          VARCHAR(256), ";
      s  += "var_name           VARCHAR, ";
      s  += "similar_to         VARCHAR, ";
      s  += "bot_name           VARCHAR, ";
      s  += "fam_name           VARCHAR, ";
      s  += "groups             VARCHAR, ";
      s  += "successions        BOOLEAN, ";
      
      s  += "description        VARCHAR, ";
      s  += "keywords           VARCHAR, ";
      s  += "fudge              FLOAT, ";
      s  += "other_req          VARCHAR, ";
      s  += "notes              VARCHAR, ";
      
      s  += "maturity           INTEGER, ";
      s  += "mat_adjust         INTEGER, ";
      s  += "misc_adjust        INTEGER, ";
 
      // ==[ PASTE ]==
      // The following columns are copied from plantingDataSchema()
      // presumably just for testing; think we'll move these back at some point?
      s += "time_to_tp          INTEGER, ";
      
      s += "rows_p_bed          INTEGER, ";
      s += "space_inrow         FLOAT, ";
      s += "space_betrow        FLOAT, ";
      
      s += "flat_size           VARCHAR, ";
      s += "planter             VARCHAR, ";
      s += "planter_setting     VARCHAR, ";

      s += "yield_p_foot        FLOAT, ";
      s += "yield_num_weeks     INTEGER, ";
      s += "yield_p_week        FLOAT, ";
      s += "crop_unit           VARCHAR, ";
      s += "crop_unit_value     FLOAT, ";
      // ==[ DONE ]==
      
      s  += "seeds_sources      VARCHAR, "; // TODO remove; factor out
      s  += "seeds_item_code    VARCHAR, "; // TODO remove; factor out
      s  += "seeds_unit_size    VARCHAR, "; // TODO remove; factor out
      
      return s;
   }
   
   static String plantingDataSchema() {
      
      String s = new String();

      s  = "id      INTEGER IDENTITY PRIMARY KEY, ";
      s += "crop_id INTEGER, ";
      s += "method  VARCHAR, ";
      
      s += "mat_adjust INTEGER, ";
      s += "time_to_tp INTEGER, ";
      
      s += "rows_p_bed   INTEGER, ";
      s += "space_inrow  INTEGER, ";
      s += "space_betrow INTEGER, ";
      
      s += "flat_size       VARCHAR, ";
      s += "planter         VARCHAR, ";
      s += "planter_setting VARCHAR, ";

      s += "yield_p_foot    FLOAT, ";
      s += "yield_num_weeks INTEGER, ";
      s += "yield_p_week    FLOAT, ";
      s += "crop_unit       VARCHAR, ";
      s += "crop_unit_value FLOAT, ";

      s += "FOREIGN KEY ( crop_id ) REFERENCES " + "CROPS_VARIETIES" + "( id ), ";
      
      return s;
      
   }
   
}
