#!/bin/sh

#
ftp_ip=ftp.wuetherich.com
ftp_port=21
target_dir=slizaa-rcp-workbench

#
for i in `curl --ssl -k -s -l ftp://"$user":"$password"@"$ftp_ip/$target_dir" | grep .jar`; do
{
       echo "deleting $i";
       curl --ssl -k ftp://"$user:$password"@"${ftp_ip}:${ftp_port}/$target_dir/${i}" -O --quote "DELE ${i}"
};
done;

for i in `curl --ssl -k -s -l ftp://"$user":"$password"@"$ftp_ip/$target_dir/plugins/" | grep .jar`; do
{
       echo "deleting plugins/$i";
       curl --ssl -k ftp://"$user:$password"@"${ftp_ip}:${ftp_port}/$target_dir/plugins/${i}" -O --quote "DELE $target_dir/plugins/${i}"
};
done;

for i in `curl --ssl -k -s -l ftp://"$user":"$password"@"$ftp_ip/$target_dir/features/" | grep .jar`; do
{
       echo "deleting features/$i";
       curl --ssl -k ftp://"$user:$password"@"${ftp_ip}:${ftp_port}/$target_dir/features/${i}" -O --quote "DELE $target_dir/features/${i}"
};
done;

for i in `curl --ssl -k -s -l ftp://"$user":"$password"@"$ftp_ip/$target_dir/releases/" | grep .zip`; do
{
       echo "deleting releases/$i";
       curl --ssl -k ftp://"$user:$password"@"${ftp_ip}:${ftp_port}/$target_dir/releases/${i}" -O --quote "DELE $target_dir/releases/${i}"
};
done;