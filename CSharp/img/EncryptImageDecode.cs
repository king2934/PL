using System;
using System.Collections.Generic;
using System.Text;
using System.Security.Cryptography;
using System.IO;


namespace Net.WDC.Common
{
    /// <summary>
    /// ��ͼƬ�ļ��ܺͽ���
    /// </summary>
    public class EncryptImageDecode
    {
        public EncryptImageDecode() { }

        public void Decode(string filePath, string savePath)
        {
            string keyStr = "wangdaochuan_king2934@126.com";
            this.DecryptFile(filePath, savePath, keyStr);
        }

        #region ���ܷ��� ͼƬ����
        /// <summary>
        /// ͼƬ����
        /// </summary>
        /// <param name="filePath">Դ�ļ�</param>
        /// <param name="savePath">�����ļ�</param>
        /// <param name="keyStr">��Կ</param>
        public void DecryptFile(string filePath, string savePath, string keyStr)
        {
            //ͨ��des����
            DESCryptoServiceProvider des = new DESCryptoServiceProvider();

            //ͨ������ȡ�ļ�
            FileStream fs = File.OpenRead(filePath);
            //��ȡ�ļ��������ַ�
            byte[] inputByteArray = new byte[fs.Length];
            //��ȡ���ļ�
            fs.Read(inputByteArray, 0, (int)fs.Length);
            //�ر���
            fs.Close();
            //��Կ����
            byte[] keyByteArray = Encoding.Default.GetBytes(keyStr);
            //�����ϣ����
            SHA1 ha = new SHA1Managed();
            //����ָ���ֽ���ָ�������ϣֵ
            byte[] hb = ha.ComputeHash(keyByteArray);
            //������Կ����
            byte[] sKey = new byte[8];
            //���ܱ���
            byte[] sIV = new byte[8];
            for (int i = 0; i < 8; i++)
                sKey[i] = hb[i];
            for (int i = 8; i < 16; i++)
                sIV[i - 8] = hb[i];
            //��ȡ������Կ
            des.Key = sKey;
            //���ܱ���
            des.IV = sIV;
            MemoryStream ms = new MemoryStream();
            CryptoStream cs = new CryptoStream(ms, des.CreateDecryptor(), CryptoStreamMode.Write);
            cs.Write(inputByteArray, 0, inputByteArray.Length);
            cs.FlushFinalBlock();
            fs = File.OpenWrite(savePath);
            foreach (byte b in ms.ToArray())
            {
                fs.WriteByte(b);
            }
            fs.Close();
            cs.Close();
            ms.Close();

        }
        #endregion

    }
}