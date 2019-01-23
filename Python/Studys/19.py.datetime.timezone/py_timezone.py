#!/usr/bin/python3
#coding=utf-8

from datetime import datetime, timedelta, timezone

utc_dt = datetime.utcnow().replace(tzinfo=timezone.utc)
print(utc_dt)
cn_dt = utc_dt.astimezone(timezone(timedelta(hours=8)))
print(cn_dt)
jan_dt = utc_dt.astimezone(timezone(timedelta(hours=9)))
print(jan_dt)
cn_2_jan_dt = cn_dt.astimezone(timezone(timedelta(hours=9)))
print(cn_2_jan_dt)