package dto;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;


    public class DateTime {

        // declare variables
        private int date;
        private int month;
        private int year;
        private int hours;
        private int minute;

        //create constructor
        public DateTime(int date, int month, int year, int hours, int minute) {
            this.date = date;
            this.month = month;
            this.year = year;
            this.hours = hours;
            this.minute = minute;
        }

        //getters and setters
        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }



    }



