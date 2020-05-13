using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Web;

namespace ShowPDF
{
    /// <summary>
    /// showPDF 的摘要说明
    /// </summary>
    public class showPDF : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            FileStream fs = File.OpenRead("E:\\GitHub\\pl\\CSharp\\ShowPDF\\test.pdf");

            byte[] buffer = new byte[fs.Length];
            fs.Position = 0;
            fs.Read(buffer, 0, (int)fs.Length);
            context.Response.Clear();
            //Response.AddHeader("Content-Disposition", "attachment;FileName=out.pdf");
            context.Response.AddHeader("Content-Length", fs.Length.ToString());
            //Response.AddHeader("Content-Disposition", "inline;FileName=out.pdf");
            context.Response.ContentType = "application/pdf";
            fs.Close();
            context.Response.BinaryWrite(buffer);
            context.Response.OutputStream.Flush();
            context.Response.OutputStream.Close();
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}