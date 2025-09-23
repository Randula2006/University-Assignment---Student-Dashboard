
        public class Lecture{
            private String unitName, startTime, endTime, dayOnWeek, unitCode;

            public Lecture(String unitName , String startTime, String endTime, String dayOnWeek, String unitCode){
                this.unitName = unitName;
                this.startTime = startTime;
                this.endTime = endTime;
                this.dayOnWeek = dayOnWeek;
                this.unitCode = unitCode;
            }

            public Lecture(){
                this.unitName = "PDI";
                this.startTime = "1054";
                this.endTime = "1234";
                this.dayOnWeek = "wednesday";
                this.unitCode = "6900PDI"; 
            }

            Lecture(Lecture lecture){
                this.unitName = lecture.unitName;
                this.startTime = lecture.startTime;
                this.endTime = lecture.endTime;
                this.dayOnWeek = lecture.dayOnWeek;
                this.unitCode = lecture.unitCode;

            }

        }

