#!/bin/sh

ftp_ip=ftp.wuetherich.com
target_dir=slizaa-rcp-workbench

echo TRAVIS_BUILD_DIR: $TRAVIS_BUILD_DIR

ARTIFACTS_DIR=$TRAVIS_BUILD_DIR/releng/org.slizaa.rcp.workbench.p2/target/repository
PRODUCTS_DIR=$TRAVIS_BUILD_DIR/releng/org.slizaa.rcp.workbench.product/target/products
echo ARTIFACTS_DIR: $ARTIFACTS_DIR
echo PRODUCTS_DIR: $PRODUCTS_DIR

#------------------------------------------------------------------
# Upload the P2 repositories
#------------------------------------------------------------------
filesToUpload=$(find $ARTIFACTS_DIR -name "*.jar" -printf '%P\n')
echo filesToUpload: $filesToUpload

# change the working directory
cd $ARTIFACTS_DIR

# upload all files
for localFile in $filesToUpload;
do
  echo "Uploading $localFile"
  curl --ssl -k -T $localFile ftp://"$user":"$password"@"$ftp_ip/$target_dir/$localFile"
done

#------------------------------------------------------------------
# Upload the product zip files
#------------------------------------------------------------------
productZipsToUpload=$(find $PRODUCTS_DIR -name "*_64.zip" -printf '%P\n')
echo productZipsToUpload: $productZipsToUpload

# change the working directory
cd $PRODUCTS_DIR

# upload all files
for localFile in $productZipsToUpload;
do
  echo "Uploading $localFile"
  curl --ssl -k -T $localFile ftp://"$user":"$password"@"$ftp_ip/$target_dir/releases/$localFile"
done
