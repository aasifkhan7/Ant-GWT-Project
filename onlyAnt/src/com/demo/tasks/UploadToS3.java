//package com.demo.gwt.shared;
//import com.amazonaws.auth.AWSCredentials;
//
//public class UploadToS3 {
//
//	public static saveImages() {
//		AWSCredentials credentials = new BasicAWSCredentials(
//				accessKey, 
//				secretKey
//				);
//	
//		AmazonS3 s3Client = AmazonS3ClientBuilder
//				.standard()
//				.withCredentials(new AWSStaticCredentialsProvider(credentials))
//				.withRegion(Regions.US_EAST_1)
//				.build();
//	
//	
//		MDC.put("methodname", "saveImages");
//		log.info("S3SavePath: {}",((AmazonS3Client) s3Client).getResourceUrl(bucketName, dealer.getDealerUUID()+"-"+dealer.getID().toString()+"/"));
//		log.info("Beginning to upload images to S3");
//		Date beforeTime = new Date();
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		log.info("Time before beginning to upload images: {}", sdf.format(beforeTime));
//		int totalImages = 0;
//		for(DealerAllVehicles dealerVehicle:it) {
//			if(dealerVehicle.getImageURL()!=null) {
//				
//				String imageUrl = dealerVehicle.getImageURL();
//				try {
//					URL imageURL = new URL(imageUrl);
//	
//					ObjectMetadata objectMetadata = new ObjectMetadata();
//	
//	
//					URLConnection conn = imageURL.openConnection();
//					Map<String, List<String>> map = conn.getHeaderFields();
//					String contentType = "";
//					map.get("Content-Type").get(0);
//					contentType = map.get("Content-Type").get(0);
//	
//					byte[] bytes = IOUtils.toByteArray(imageURL.openConnection().getInputStream());
//					objectMetadata.setContentLength(bytes.length);
//					String imageName = dealerVehicle.getVIN();
//					objectMetadata.setContentType(contentType);
//					ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//	
//					String path = dealer.getDealerUUID()+"-"+dealerVehicle.getDealerID().toString()+"/"+imageName+"."+contentType.substring(contentType.lastIndexOf("/")+1);
//	
//					PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, path, 
//							byteArrayInputStream,objectMetadata);
//					s3Client.putObject(putObjectRequest.withCannedAcl((CannedAccessControlList.PublicRead)));
//	
//					List<Tag> listOfTag = new ArrayList<Tag>();
//					Tag dIDTag = new Tag("dealer_id", String.valueOf(dealer.getID()));
//					listOfTag.add(dIDTag);
//					ObjectTagging tagging = new ObjectTagging(listOfTag);
//					putObjectRequest.setTagging(tagging);
//	
//					log.info("Original Image URL: {}",imageUrl);
//					log.info("Saved Image: {}",((AmazonS3Client) s3Client).getResourceUrl(bucketName, path));
//					dealerVehicle.setImageURL(((AmazonS3Client) s3Client).getResourceUrl(bucketName, path));
//					totalImages+=1;
//					
//				} catch (Exception e) {
//					log.error("Failed to upload the image to S3 for vehicle with VIN: {}",dealerVehicle.getVIN(), e);
//					log.info("Setting the imageURL to NULL for the vehicle with VIN: {} to be inserted in DB", dealerVehicle.getVIN());
//	
//				}
//			}
//		}
//		Date afterTime = new Date();
//		log.info("Time after uploading images: {}", sdf.format(afterTime));
//		log.info("Time taken for uploading approximately {} images: {}ms", totalImages, Math.abs(afterTime.getTime() - beforeTime.getTime()));
//		
//		List<DealerAllVehicles> list = StreamSupport 
//				.stream(it.spliterator(), false) 
//				.collect(Collectors.toList()); 
//		log.info("Successfully uploaded images to S3 and returning modified DealerAllVehicles list..");
//		return list;
//	}
//
//}