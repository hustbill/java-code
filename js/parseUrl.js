
const url = 'VDP_DMPD_Integration_4XXs_SANDBOX_VTS{api=GET-/arm/issuer-controller/v1/issuer/cardart/account/-accountID}'

const encodeUrl = url => {
  let newUrl = encodeURIComponent(url);
  return newUrl;
}

const decodeUrl = url => {
  return decodeURIComponent(url);
}


const newUrl = encodeUrl(url);
console.log('Encoded URL: ', newUrl);

const originalUrl = decodeUrl(newUrl);
console.log('originalUrl : ', originalUrl);
